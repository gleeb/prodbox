##Angular 2.X TypeScript starter kit


###Installation

Requirements:

- NodeJS

Installation:

```bash
npm install -g gulp typescript karma karma-cli  
npm install
```

To run:

```bash
gulp
```

###Usage

The starter kit is meant to be used by anyone who wants to get a taste of Angular 2.X apps 

###Testing
To run the tests, run `npm test` or `karma start`.

`Karma` combined with Webpack runs all files matching `*.spec.js` inside the `app` folder. This allows us to keep test files local to the component--which keeps us in good faith with continuing to build our app modularly. The file `spec.bundle.js` is the bundle file for **all** our spec files that Karma will run.

Be sure to define your `*.spec.js` files within their corresponding component directory. You must name the spec file like so, `[name].spec.js`. If you don't want to use the `.spec.js` suffix, you must change the `regex` in `spec.bundle.js` to look for whatever file(s) you want.
`Mocha` is the testing suite and `Chai` is the assertion library. If you would like to change this, see `karma.conf.js`.

