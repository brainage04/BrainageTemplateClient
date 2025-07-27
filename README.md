# About
My template for Minecraft Fabric client-side mods. The easiest way to use this is to click `Use this template` and GitHub Actions will take care of the rest for you.

However, if you are using a Linux-based operating system, it is possible to clone this repository, and perform a refactor by triggering the `init.sh` script like so:
```shell
./init.sh io.github.<github_username> <mod_name> <mod_id> <github_username> 
```

Typically for most people `<mod_id>` is just a lowercase version of `<mod_name>`, however I left them as separate arguments just in case.

# Credits
Thank you to [nea89o](https://github.com/nea89o)
for developing the GitHub Actions [workflow](https://github.com/nea89o/Forge1.8.9Template/blob/master/.github/workflows/init.yml)
and [script](https://github.com/nea89o/Forge1.8.9Template/blob/master/make-my-own.sh)
from which I based my workflow and script off of.

# Todo
Port to 1.21.8
Test with `Use this template` button (only tested locally so far)