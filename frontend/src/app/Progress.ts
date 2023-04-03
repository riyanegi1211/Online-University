import { end } from "@popperjs/core";

export class Progress{
    title:string;
    start:string;
    end:string;

    constructor(title:string, start:string, end:string){
        this.title= title;
        this.start= start;
        this.end= end;
    }
}