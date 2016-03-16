/// <reference path="../typings/tsd.d.ts" />

import "angular2/bundles/angular2-polyfills";
import {HTTP_PROVIDERS} from "angular2/http";
import { bootstrap } from "angular2/platform/browser";
import { MyAppComponent } from "./app.component";

bootstrap(MyAppComponent, [HTTP_PROVIDERS]);
