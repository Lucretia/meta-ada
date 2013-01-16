DESCRIPTION = "Test Ada layer - Simple library in Ada"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"

SRC_URI = "file://libhello.ads file://libhello.adb file://libhello.gpr file://build_libhello.gpr"

# Install the files as:
#
# /usr/lib/ada/libhello/adainclude/libhello.ads
# /usr/lib/ada/libhello/adalib/libhello.ali
# /usr/lib/ada/libhello/libhello.gpr
# /usr/lib/libhello.a
# /usr/lib/libhello.so

PACKAGES = "${PN}-dev"

#FILES_${PN} = "${bindir}/*"

FILES_${PN}-dev = "${libdir}/* ${libdir}/ada/${PN}/*"

#FILES_${PN}-dbg = "${bindir}/.debug/*"

S = "${WORKDIR}"

do_compile() {
	${TARGET_PREFIX}gnatmake -p -Pbuild_libhello.gpr
}

do_install() {
	install -d ${D}${libdir}
	install -d ${D}${libdir}/ada
	install -d ${D}${libdir}/ada/${PN}
	install -d ${D}${libdir}/ada/${PN}/adainclude
	install -d ${D}${libdir}/ada/${PN}/adalib
	install -m 0644 libhello.gpr ${D}${libdir}/ada/${PN}
	install -m 0644 libhello.ads ${D}${libdir}/ada/${PN}/adainclude
	install -m 0644 lib/libhello.ali ${D}${libdir}/ada/${PN}/adalib
	install -m 0644 lib/libhello.a ${D}${libdir}/ada/${PN}/adalib
#	install -m 0755 lib/libhello.so.1 ${D}${libdir}
#	install -m 0777 lib/libhello.so ${D}${libdir}

	# At the end of the build add in the project to the GPR path with the colon at the end ready for more.
	GPR_PROJECT_PATH .= ":${D}${libdir}/ada/${PN}"
}

