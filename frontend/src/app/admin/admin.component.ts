import { Component, OnInit, ViewChild } from '@angular/core';
import { ChartConfiguration, ChartData, ChartEvent, ChartType } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import DatalabelsPlugin from 'chartjs-plugin-datalabels';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit{
	openSidebar: boolean = true;

	menuSidebar = [
	  {
		link_name: "Dashboard",
		link: "/dashboard",
		sub_menu: [],
        icon: "bx bx-book-alt",
	  }, 
	  {
		link_name: "Category",
		link: null,
		icon: "bx bx-book-alt",
		sub_menu: [
		  {
			link_name: "HTML & CSS",
			link: "/html-n-css",
		  }, {
			link_name: "JavaScript",
			link: "/javascript",
		  }, {
			link_name: "PHP & MySQL",
			link: "/php-n-mysql",
		  }
		]
	  }, 
	  {
		link_name: "Posts",
		link: null,
		icon: "bx bx-book-alt",
		sub_menu: [
		  {
			link_name: "Web Design",
			link: "/posts/web-design",
		  }, {
			link_name: "Login Form",
			link: "/posts/login-form",
		  }, {
			link_name: "Card Design",
			link: "/posts/card-design",
		  }
		]
	  }, 
	  {
		link_name: "Analytics",
		link: "/analytics",
		icon: "bx bx-pie-chart-alt-2",
		sub_menu: []
	  }, 
	  {
		link_name: "Chart",
		link: "/chart",
		icon: "bx bx-line-chart",
		sub_menu: []
	  }, 
	  {
		link_name: "Plugins",
		link: null,
		icon: "bx bx-plug",
		sub_menu: [
		  {
			link_name: "UI Face",
			link: "/ui-face",
		  }, {
			link_name: "Pigments",
			link: "/pigments",
		  }, {
			link_name: "Box Icons",
			link: "/box-icons",
		  }
		]
	  }, 
	  {
		link_name: "Explore",
		link: "/explore",
		icon: "bx bx-compass",
		sub_menu: []
	  }, 
	  {
		link_name: "History",
		link: "/history",
		icon: "bx bx-history",
		sub_menu: []
	  }, 
	  {
		link_name: "Setting",
		link: "/setting",
		icon: "bx bx-cog",
		sub_menu: []
	  }
	]
  
	constructor() { }
  
	ngOnInit() {
  
	}
  
	showSubmenu(itemEl: HTMLElement) {
	  itemEl.classList.toggle("showMenu");
	}

    @ViewChild(BaseChartDirective) chart: BaseChartDirective | undefined;

    // Pie
    public pieChartOptions: ChartConfiguration['options'] = {
      responsive: true,
      plugins: {
        legend: {
          display: true,
          position: 'left',
        },
        datalabels: {
          formatter: (value, ctx) => {
            if (ctx.chart.data.labels) {
              return ctx.chart.data.labels[ctx.dataIndex];
            }
          },
        },
      }
    };
    public pieChartData: ChartData<'pie', number[], string | string[]> = {
        labels: [ 'Download Sales' , 'In Store Sales' , 'Mail Sales' ],
        datasets: [ {
            data: [ 300, 500, 100 ],
            backgroundColor: ['#E1D33F','#F04B4B','#57F35F']
        } ]
    };
    public pieChartType: ChartType = 'pie';
    public pieChartPlugins = [ DatalabelsPlugin ];

  
    // events
    public chartClicked({ event, active }: { event: ChartEvent, active: {}[] }): void {
      console.log(event, active);
    }
  
    public chartHovered({ event, active }: { event: ChartEvent, active: {}[] }): void {
      console.log(event, active);
    }
}
