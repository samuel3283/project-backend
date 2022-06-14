#!/bin/sh -e

# echo "Setting up project $PROFILE"
# echo "Starting Web Server ..."
# nginx -g 'daemon off;'

default_ws='https://recomiendauntalento.pe'
#default_portal='http://portal.farmaciasperuanas.pe'

# Develop
dev_des='http://dev.talento.solucionesfps.pe'
#dev_portal='http://dev.portalfarmaciasweb.solucionesfps.pe'

# QA
qa_des='http://qa.talento.solucionesfps.pe'
#qa_portal='http://dev.portalfarmaciasweb.solucionesfps.pe'

# Folder project, equal name dist folder
folder=fps-web-talento

# Folder dest, autoconfig
file_dest=/var/www/html/$folder/main.*

if [ "$PROFILE" == "LOCAL" ]
then
    echo "Setting up project $PROFILE"
    echo "Starting Web Server ..."
    nginx -g 'daemon off;'

elif [ "$PROFILE" == "DEV" ]
then

    echo "Setting up project $PROFILE"
    echo "backend for dev"
    for i in $file_dest; do
      sed -i -e "s+$default_ws+$dev_des+g" $i
    done
    echo "filestorage for dev"
    nginx -g 'daemon off;'

elif [ "$PROFILE" == "QA" ]
then

    echo "Setting up project $PROFILE"
    echo "backend for qa"
    for i in $file_dest; do
      sed -i -e "s+$default_ws+$qa_des+g" $i
    done
    echo "filestorage for qa"
    nginx -g 'daemon off;'

elif [ "$PROFILE" == "PRD" ]
then

    echo "Setting up project $PROFILE"
    echo "backend for prod"
    echo "filestorage for prod"
    nginx -g 'daemon off;'

else
    echo "Please enter a valid PROFILE option [ LOCAL, DEV, QA, PRD ]"
    nginx -g 'daemon off;'
fi
