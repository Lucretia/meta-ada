#SRC_URI="http://mirrors.cdn.adacore.com/art/0332ffe06bc598f0b94b3a027f30ea2be6dc5dec;downloadfilename=xmlada-4.3w-src.tgz"
#SRC_URI[md5sum] = "764c474e8334b263dc3c2dd95693484d"

#SRC_URI="file://xmlada-4.3w.tgz;md5sum=19f52b80968dd5ed89cc3e83c82c2033"
SRC_URI="file://xmlada-4.3w-src.tgz;md5sum=764c474e8334b263dc3c2dd95693484d"

LICENSE = "GPLv2"

LIC_FILES_CHKSUM="file://README;beginline=267;endline=273;md5=dcc62554ef362dd7327e3d149c383fbf"

#PR="r1"

S = "${WORKDIR}/${BPN}-${PV}-src"
#S = "${WORKDIR}"

inherit native

