import {Component, Input, Output, EventEmitter} from "angular2/core";


@Component({
  selector: "input-form-component",
  template: `
  <div class="form-group">
    <label class="control-label" for="focusedInput">{{title}}</label>
    <div class="controls">
      <input class="form-control focused" id="focusedInput" type="text" [ngModel]="value"
      (ngModelChange)="valueChanged($event)">
    </div>
  </div>
    `
})
export class InputFormComponent {
  @Input("value") value;
  @Output ("valueChanged") onChange = new EventEmitter();

  valueChanged(event) {
    this.onChange.emit(event);
  }

}
