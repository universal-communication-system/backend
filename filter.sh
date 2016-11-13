#!/bin/bash

curl -v -d "$(jq "{\"data\":.}" -R -r)" -m 2 -H "Content-Type: application/json" "https://tonefilter.mybluemix.net/url" | sed -e "s|\r||g"
