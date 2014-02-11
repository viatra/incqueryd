#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Usage: $0 path-to-eclipse-directory"
    echo "Make sure your Eclipse installation has EMF installed."
    exit
fi

mvn eclipse:to-maven -DstripQualifier=true -DeclipseDir=$1
