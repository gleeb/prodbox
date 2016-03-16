import {Component} from "angular2/core";


@Component({
  selector: "jsoneditor-form-component",
  template: `
  <div class="form-group">
    <label class="control-label" for="textarea2">Json editor</label>
    <div class="controls">
      <textarea id="limit" rows="6" style="width: 100%; overflow: hidden; word-wrap: break-word; resize: horizontal; height: 126px;"></textarea>
    </div>
  </div>
    `
})
export class JsonEditorFormComponenet {
}
