import { Component, View } from "angular2/core";


@Component({
  selector: "header-component",
  template: `
   <div class="navbar">
      <div class="container">
        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".sidebar-nav.nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#/"> <img alt="DoubleTime Dashboard" src="assets/img/logo20.png" /> <span>Lantern.io</span></a>

        <div class="header-nav">
          <ul class="nav navbar-nav pull-right">
            <li class="dropdown hidden-xs">
              <a class="btn dropdown-toggle" data-toggle="dropdown" href="index.html#">
                <i class="fa fa-user"></i>
                <span class="caret"></span>
              </a>
              <ul class="dropdown-menu">
                <li><a href="index.html#"><i class="fa fa-user"></i> Profile</a></li>
                <li><a href="login.html"><i class="fa fa-off"></i> Logout</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
  `
})
export class HeaderComponent {
  constructor() {
  }
}
