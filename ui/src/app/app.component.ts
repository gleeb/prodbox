import { Component, View } from "angular2/core";
import { MyService } from "./services/sampleService";
import { SubComponent } from "./components/subcomponent.component";
import { HeaderComponent } from "./components/header.component";
import { MainMenuComponent } from "./components/mainmenu.component";
import { InputFormComponent } from "./components/formcomponents/input.component";
import { TestCaseComponent } from "./components/testcase.form.component.ts";

@Component({
  selector: "my-app",
  bindings: [MyService],
  template: `
      <div>
        <header-component></header-component>
        <div class="container">
          <div class="row">
            <div class="col-sm-2 main-menu-span">
              <mainmenu-component></mainmenu-component>
            </div>
            <div id="content" class="col-sm-10">
              <testcase-form-component></testcase-form-component>
            </div>
          </div>
      </div>
    </div>
  `,
  directives: [SubComponent, HeaderComponent, MainMenuComponent, TestCaseComponent]
})
export class MyAppComponent {
  appStatus: string;
  serviceStatus: string;

  constructor(myService: MyService) {
    myService.getMessage();

    this.appStatus = "Application is working.";
  }
}
