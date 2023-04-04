import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

	constructor() { }
	private userId!:number;

	setUserId(data:number){
		this.userId= data;
	}

	getUserId(){
		return this.userId;
	}
}
