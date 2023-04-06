export class Course{
    courseId!:number;
    courseCode:number;
    courseName:string;
    totalLectures:number;
    status:string;

    constructor(courseCode:number, courseName:string, totalLectures:number, status:string)
    {
        this.courseCode= courseCode;
        this.courseName= courseName;
        this.totalLectures= totalLectures;
        this.status= status;
    }
}