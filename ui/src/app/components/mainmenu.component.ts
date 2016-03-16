import { Component, View } from "angular2/core";


@Component({
  selector: "mainmenu-component",
  template: `
          <div class="sidebar-nav nav-collapse collapse navbar-collapse">
            <ul class="nav nav-tabs nav-stacked main-menu">
              <li><a href="#/"><i class="fa fa-home icon"></i><span class="hidden-sm">Home</span></a></li>
              <li><a href="#testcases"><i class="fa fa-home icon"></i><span class="hidden-sm">Test Cases</span></a></li>
              <li><a href="#playground1"><i class="fa fa-home icon"></i><span class="hidden-sm">Playground-1</span></a></li>
              <li><a href="#playground2"><i class="fa fa-home icon"></i><span class="hidden-sm">Playground-2</span></a></li>
            </ul>
          </div>
  `
})
export class MainMenuComponent {
  constructor() {
  }
}
