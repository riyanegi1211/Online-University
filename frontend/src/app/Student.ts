export class Student{
	id!:number;
	studentId:number;
	firstName:string;
	lastName:string;
	studentBranch:string;
	studentSemester:string;


	constructor(studentId:number, firstName:string, lastName:string, studentBranch:string, studentSemester:string){
		this.studentId= studentId;
		this.studentBranch= studentBranch;
		this.firstName= firstName;
		this.lastName= lastName;
		this.studentSemester= studentSemester;
	}
}