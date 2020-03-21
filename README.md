# Integrated Traveler System (ITS)

## Setting up project

1. `git clone https://github.com/gutucristian/ITS.git`
2. Open project in `IntelliJ IDEA`
3. Right click on `pom.xml`: `Maven` > `Download Sources`
4. In the navigation bar select `Edit Configurations`. Next, in the top left corner, click `+` and select `Application`. Name it `Main` and select the main class (in `src/main/java/` as the `Main class`). Apply settings and hit `Ok`.
5. On MacOS, run by pressing `Ctrl+R`.
6. If you get a "release version not supported" error, then go to project folder, right click and select `Open Module Settings`. Select appropriate language level here. If error persists, then go to `Preferences` > `Build, Execution, Deployment` > `Compiler` > `Java Compiler` and update `Target bytecode version`.

What to `.gitignore`:
- https://github.com/intellij-rust/intellij-rust/issues/1570

## TODO

- [ ] documented classes
- [ ] test cases
- [ ] half-page writeup of how the work was distributed among individual team members, and the rationale
behind this distribution
- [ ] total time spent on the implementation and testing of each clas
- [ ] total time spent on testing the integration of the classes
- [ ] half-page writeup of the difficulties that you encountered
- [ ] half-page writeup of what you would do differently if you were asked to do another assignment of this
scope
