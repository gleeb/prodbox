import {Component} from "angular2/core";
import {InputFormComponent} from "./formcomponents/input.component";
import {JsonEditorFormComponenet} from "./formcomponents/jsoneditor.component";
import {TestCaseStepFormComponent} from "./testcase.form.step.component";


@Component({
  selector: "testcase-form-component",
  template: `
  <form class="form-horizontal">
    <fieldset class="col-sm-12">
      <testcase-step-form-component></testcase-step-form-component>
      <div class="form-actions">
        <button type="submit" class="btn btn-primary">Save changes</button>
        <button type="reset" class="btn">Cancel</button>
      </div>
    </fieldset>
  </form>
    `,
    directives: [InputFormComponent, JsonEditorFormComponenet, TestCaseStepFormComponent]
})
export class TestCaseComponent {

}
