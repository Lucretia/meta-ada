DESCRIPTION = "Common library for Ada projects on ada.cx."
AUTHOR = "Jerrid Kimball"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD;md5=3775480a712fc46a69647678acb234cb"
SECTION = "libs"
#DEPENDS = ""
SRC_URI = "git://git.scm.ada.cx/cgi-bin/cgit.cgi/common.git;protocol=http"
SRCREV = "47800eda6e93d31a8accc8132f073106d1e9a4e1"

PR = "r0"

S = "${WORKDIR}"

do_compile() {
	cd git
	${TARGET_PREFIX}gnatmake -p -Pcommon.gpr
}

do_install() {
	install -d ${D}${libdir}/ada/common/source
	install -d ${D}${libdir}/ada/common/library

        install -m 0644 git/common.gpr ${D}${libdir}/ada/common
        install -m 0644 git/source/*.ads ${D}${libdir}/ada/common/source

        install -m 0644 git/library/*.ali ${D}${libdir}/ada/common/library
        install -m 0644 git/library/lib*.a ${D}${libdir}/ada/common/library
}
