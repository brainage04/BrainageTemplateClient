# About
My template for Minecraft Fabric client-side mods. The easiest way to use this is to click `Use this template` and GitHub Actions will take care of the rest for you.

However, if you are using a Linux-based operating system, it is possible to clone this repository, and perform a refactor by triggering the `init.sh` script like so:
```shell
./init.sh <package_name> <mod_name> <mod_id> <github_username> 
```

This script is designed to work both with GitHub Actions and manual usage, and will safely delete:
  - Leftover unused folders that are not tracked by Git (src/main/java/com/example and src/main/resources/examplemod).
  - The `init` workflow and script after successful execution.

Typically for most people `<mod_id>` is just a lowercase version of `<mod_name>`,
and their package name ends with `<github_username>`,
however I left them all as separate arguments just in case.

# Credits
Thank you to [nea89o](https://github.com/nea89o)
for developing the GitHub Actions [workflow](https://github.com/nea89o/Forge1.8.9Template/blob/master/.github/workflows/init.yml)
and [script](https://github.com/nea89o/Forge1.8.9Template/blob/master/make-my-own.sh)
from which I based my workflow and script off of.

# Todo
Simplify init script (just use username and mod name,
then package name = com.github.username,
and mod id = mod name but in all lowercase)