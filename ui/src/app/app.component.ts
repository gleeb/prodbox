import {Component, Input, Output, EventEmitter} from "angular2/core";
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
  <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>

    <div style="top: 80%; left: 30%; position: absolute;">
        <div>Insert a amazon product link</div>
        <div class="controls">
          <input class="form-control focused" id="focusedInput" type="text" [ngModel]="value"
          (ngModelChange)="valueChanged($event)">
        </div>
    </div>

  `,
  directives: [ TestCaseComponent]
})
export class MyAppComponent {

  @Input("value") value;
  @Output ("valueChanged") onChange = new EventEmitter();

  valueChanged(event){
    this.onChange.emit(event);
    
    let response1 = service.getMessage();

    console.log(response1);


  }


  appStatus: string;


  constructor(myService: MyService) {
    myService.getMessage();
    service=myService;
    this.appStatus = "Application is working.";
  }
}

let service: MyService;
