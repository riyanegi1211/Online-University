export class CoursesData {
	courseId: number;
	courseName: string;
	totalLectures:number;
    courseCode: string;
	status: string;

	constructor(courseId:number, courseName:string, totalLectures:number, courseCode:string, status:string)
	{
		this.courseId= courseId;
		this.courseName= courseName;
		this.totalLectures= totalLectures;
        this.courseCode= courseCode;
		this.status= status;
	}
}
