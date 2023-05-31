package com.example.enrollment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.enrollment.model.CourseList;
import com.example.enrollment.model.CourseSummary;
import com.example.enrollment.model.Enrollment;
import com.example.enrollment.model.StudentCourseData;
import com.example.enrollment.model.StudentCourseDataAttendance;
import com.example.enrollment.model.StudentCourseDataFile;
import com.example.enrollment.model.StudentList;
import com.example.enrollment.repository.EnrollmentRepository;
import com.example.enrollment.repository.StudentCourseDataAttendanceRepository;
import com.example.enrollment.repository.StudentCourseDataFileRepository;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentCourseDataAttendanceRepository studentCourseDataAttendanceRepository;

    @Autowired
    private StudentCourseDataFileRepository fileRepository;

    // will only return courseId
    @GetMapping("courses/student/{userId}")
    public List<CourseList> getCoursesForUserId(@PathVariable long userId) {
        List<Enrollment> enrollments = enrollmentRepository.findAllByUserId(userId);
        List<CourseList> cList = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            cList.add(new CourseList(enrollment.getCourseId()));
        }
        return cList;
    }

    // will only return studentId
    @GetMapping("courses/{courseId}")
    public List<StudentList> getStudentForCourseId(@PathVariable long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findAllByCourseId(courseId);
        List<StudentList> cList = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            cList.add(new StudentList(enrollment.getUserId()));
        }
        return cList;
    }

    // will only return studentId
    @GetMapping("courses/{courseId}/student/{userId}/attendance")
    public List<StudentCourseData> getCourseStudentAttendance(@PathVariable long courseId, @PathVariable long userId) {
        Enrollment enrollment = enrollmentRepository.findByCourseIdAndUserId(courseId, userId).orElse(null);
        if (enrollment == null)
            return null;
        List<StudentCourseDataAttendance> attendanceList = studentCourseDataAttendanceRepository
                .findAllByEnrollmentId(enrollment.getEnrollmentId());
        List<StudentCourseData> cList = new ArrayList<>();

        for (StudentCourseDataAttendance attendance : attendanceList) {
            cList.add(new StudentCourseData(enrollment.getUserId(), enrollment.getCourseId(), attendance.getDataId()));
        }

        return cList;
    }

    @PostMapping("student/{userId}/courses/{courseId}/upload")
    public String uploadFile(@PathVariable long userId, @PathVariable long courseId, @RequestBody MultipartFile file) throws IOException {
        Enrollment enrollment = enrollmentRepository.findByCourseIdAndUserId(courseId, userId).orElse(null);
        if (enrollment == null)
            return "Failed";

        System.out.println(file.isEmpty());
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            // String ext = file.getContentType();
            String filePath = "src/main/resources/static/files/" + String.valueOf(userId)  + "/" + fileName;
            File localFile = new File(filePath);

            try (OutputStream os = new FileOutputStream(localFile)) {
                os.write(file.getBytes());
            }
            StudentCourseDataFile dataFile = new StudentCourseDataFile();
            dataFile.setEnrollmentId(enrollment.getEnrollmentId());
            dataFile.setFileName(fileName);

            fileRepository.save(dataFile);
            return "Successful";
        }

        return "Failed";
    }

    @GetMapping("student/{userId}/courses/{courseId}/files")
    public List<String> getFile(@PathVariable long userId, @PathVariable long courseId) {
        Enrollment enrollment = enrollmentRepository.findByCourseIdAndUserId(courseId, userId).orElse(null);
        if (enrollment == null)
            return null;

        List<StudentCourseDataFile> files = new ArrayList<>();
        files = fileRepository.findAllByEnrollmentId(enrollment.getEnrollmentId());

        List<String> fileNames = new ArrayList<>();

        for (StudentCourseDataFile f : files) {
            fileNames.add(f.getFileName());
        }
        return fileNames;
    }
}
