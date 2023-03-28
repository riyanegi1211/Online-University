import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit{
	title = 'OnlineUniversity';

	ngOnInit(): void {
		// // alert js
		// const alertPlaceholder = document.getElementById('liveAlertPlaceholder')
	
		// const alert = (message : string, type : string) => {
		//   const wrapper = document.createElement('div')
		//   wrapper.innerHTML = [
		// 	`<div class="alert alert-${type} alert-dismissible" role="alert">`,
		// 	`   <div>${message}</div>`,
		// 	'   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
		// 	'</div>'
		//   ].join('')
	
		//   alertPlaceholder?.append(wrapper)
		// }
	
		// const alertTrigger = document.getElementById('liveAlertBtn')
		// if (alertTrigger) {
		//   alertTrigger.addEventListener('click', () => {
		// 	alert('Hey, this is a earthquake alert', 'danger')
		//   })
		// }
	
	
	
		// // popover js
		// const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]')
		// const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl))
		// // SO50234481
	
	
		// // toast js
		// const toastTrigger = document.getElementById('liveToastBtn')
		// const toastLiveExample = document.getElementById('liveToast')! // SO63520680
		// if (toastTrigger) {
		//   toastTrigger.addEventListener('click', () => {
		// 	const toast = new bootstrap.Toast(toastLiveExample)
	
		// 	toast.show()
		//   })
		// }
	
		// // tooltip js
		// const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
		// const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
	}

}
