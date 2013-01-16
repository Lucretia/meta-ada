DESCRIPTION = "Test Ada layer - Simple hello, world application in Ada"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"

SRC_URI = "file://hello.adb file://hello.gpr"

S = "${WORKDIR}"

do_compile() {
	${TARGET_PREFIX}gnatmake -p -Phello.gpr
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 hello ${D}${bindir}
}

