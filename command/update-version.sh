#!/bin/bash

if [ -z "$1" ]
then
  echo "N0 version argument supplied"
  exit 0
fi

mvn versions:set -DgenerateBackupPoms=false -DnewVersion="${1}"
sed -i "s/<version>.*<\/version>/<version>${1}<\/version>/g" README.MD