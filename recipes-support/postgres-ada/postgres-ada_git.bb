DESCRIPTION = "Ada binding to PostgreSQL."
AUTHOR = "Samuel Tardieu"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://source/pgada.ads;beginline=1;endline=37;BSD;md5=39284fb050aec8e85959db1d3c08ee6b"
SECTION = "libs"
DEPENDS = "postgresql"
#SRC_URI = "git://git.scm.ada.cx/postgres-ada.git;protocol=git"
SRC_URI = "http://git.scm.ada.cx/cgi-bin/cgit.cgi/postgres-ada.git;protocol=git"

PR = "r0"

S = "${WORKDIR}"

do_compile() {
	${TARGET_PREFIX}gnatmake -Ppgada.gpr
}
