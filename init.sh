#!/bin/bash
if [ "$#" -ne "2" ]; then
  echo "Usage: $0 <owner> <project name>"
  exit 0
fi

base=$(dirname "$(readlink -f "$0")")
echo "Updating $base"

owner="$1"
project_name="$2"
package_name="com.github.$owner"
modid=$(echo "$project_name" | tr '[:upper:]' '[:lower:]')
package_dir=$(echo "$package_name" | tr . /)
echo "Setting owner to $owner"
echo "Setting project name to $project_name"
echo "Setting package name to $package_name"
echo "Setting mod id to $modid"
echo "Setting package dir to $package_dir"

(
  # enable debug tracing
  set -x

  # refactor mod id, mod name, owner and package name strings
  # important that owner is done before package name
  # as owner may or may not be in the package name string
  # which will cause issues if replaced
  find "$base/src/main" -type f -exec sed -i \
      -e "s/examplemod/$modid/g" \
      -e "s/ExampleMod/$project_name/g" \
      -e "s/brainage04/$owner/g" \
      -e "s/com\.example/$package_name/g" {} +

  sed -i \
        -e "s/examplemod/$modid/g" \
        -e "s/ExampleMod/$project_name/g" \
        -e "s/brainage04/$owner/g" "$base/build.gradle"

  sed -i \
      -e "s/com\.example/$package_name/g" \
      -e "s/examplemod/$modid/g" "$base/gradle.properties"

  sed -i \
        -e "s/brainage04/$owner/g" "$base/LICENSE"

  # refactor accesswidener and mixin file names
  mv "$base"/src/main/resources/examplemod.accesswidener "$base"/src/main/resources/"$modid".accesswidener
  mv "$base"/src/main/resources/examplemod.mixins.json "$base"/src/main/resources/"$modid".mixins.json

  # refactor assets directory
  mv "$base"/src/main/resources/assets/examplemod "$base"/src/main/resources/assets/"$modid"

  # rename main class
  mv "$base"/src/main/java/com/example/ExampleMod.java "$base"/src/main/java/com/example/"$project_name".java

  # lastly, refactor package directory
  mkdir -p "$base"/src/main/java/"$package_dir"
  mv "$base"/src/main/java/com/example/* "$base"/src/main/java/"$package_dir"
  rmdir "$base"/src/main/java/com/example
  rmdir "$base"/src/main/java/com

  rm "$base"/.github/workflows/init.yml
  rm "$(readlink -f $0)"
)

echo "Refactor completed successfully"