(sleep 20; gradle buildAndReload --continuous -PskipDownload=true --warning-mode all -x Test)&
gradle bootRun -PskipDownload=true -Dspring.profiles.active=development 