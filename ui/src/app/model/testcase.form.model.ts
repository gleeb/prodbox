import {TestCaseStep} from "./testcase.step.model";

export class TestCaseForm {
    public name: string;
    public type: string;
    public steps: TestCaseStep[];

  constructor(name: string, type: string, steps: TestCaseStep[]) {
    this.name = name;
    this.type = type;
    this.steps = steps;
  }
}
