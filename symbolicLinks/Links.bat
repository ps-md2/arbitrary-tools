echo "Caution: Change local paths first! Press Ctrl-C to escape."
pause
REM Creates links in the filesystem for redirection of changes of the model to the jetty server of netbeans and the backend running on the tomcat.
mklink /j NETBEANS\md2_app_ReferenceProject ECLIPSEREPO\ReferenceProject\src-gen\ReferenceProject.mapapps\md2_app_ReferenceProject
mklink /j TOMCAT\webapps\Backend ECLIPSEREPO\md2-projects\ReferenceProject\src-gen\ReferenceProject.backend\WebContent
