import { Injectable } from "angular2/core";
import {Http, Headers} from "angular2/http";
import "rxjs/Rx";

@Injectable()
export class MyService {
  message: string;

  constructor(public http: Http) {
    this.message = "Services are working";
  }

  public getMessage() {
    this.http.get("api/health")
        .map(res =>{res.text()} )
        .subscribe(
          data => console.log(data),
          err => console.log(err),
          () => console.log("Random Quote Complete")
        );
  }

}
