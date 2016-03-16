import {Component} from "angular2/core";
import {InputFormComponent} from "./formcomponents/input.component";
import {TestCaseStep} from "../model/testcase.step.model";
import {JsonEditorFormComponenet} from "./formcomponents/jsoneditor.component";


@Component({
  selector: "testcase-step-form-component",
  template: `
  <form class="form-horizontal">
    <fieldset class="col-sm-12">
      <input-form-component title="Step Name" value={{stepName}} (valueChanged)="stepNameEdited($event)"></input-form-component>
      <jsoneditor-form-component></jsoneditor-form-component>
    </fieldset>
  </form>
    `,
    directives: [InputFormComponent, JsonEditorFormComponenet]
})
export class TestCaseStepFormComponent {
  stepName: string;

  constructor() {
    this.stepName = "initial value";
  }

  stepNameEdited(text: string) {
    this.stepName = text;
  }

}
