# Language overrides
# Modelled after gcc-4.6.inc
ADA := ",ada"

LANGUAGES .= "${ADA}"

# Should the above have ADA_arm[eb]|mips[el]|etc. as in gcc-configure-common.inc?

# Modelled after gcc-package-target.inc
PACKAGES += "\
  gnat gnat-symlinks \
  gnat-dev \
"

FILES_gnat = "\
  ${bindir}/${TARGET_PREFIX}gnat \
  ${bindir}/${TARGET_PREFIX}gnatbind \
  ${bindir}/${TARGET_PREFIX}gnatchop \
  ${bindir}/${TARGET_PREFIX}gnatclean \
  ${bindir}/${TARGET_PREFIX}gnatfind \
  ${bindir}/${TARGET_PREFIX}gnatkr \
  ${bindir}/${TARGET_PREFIX}gnatlink \
  ${bindir}/${TARGET_PREFIX}gnatls \
  ${bindir}/${TARGET_PREFIX}gnatmake \
  ${bindir}/${TARGET_PREFIX}gnatname \
  ${bindir}/${TARGET_PREFIX}gnatprep \
  ${bindir}/${TARGET_PREFIX}gnatxref \
  ${libexecdir}/gcc/${TARGET_SYS}/${BINV}/gnat1 \
  ${gcclibdir}/${TARGET_SYS}/${BINV}/adalib/lib*${SOLIBS} \
"

FILES_gnat-dev = "\
  ${gcclibdir}/${TARGET_SYS}/${BINV}/adalib/*.ali \
  ${gcclibdir}/${TARGET_SYS}/${BINV}/adalib/lib*.a \
  ${gcclibdir}/${TARGET_SYS}/${BINV}/adainclude/*.ad[sb] \
"

FILES_gnat-symlinks = "\
  ${bindir}/gnat \
  ${bindir}/gnatbind \
  ${bindir}/gnatchop \
  ${bindir}/gnatclean \
  ${bindir}/gnatfind \
  ${bindir}/gnatkr \
  ${bindir}/gnatlink \
  ${bindir}/gnatls \
  ${bindir}/gnatmake \
  ${bindir}/gnatname \
  ${bindir}/gnatprep \
  ${bindir}/gnatxref \
"

do_install_append() {
        if [ -e ${TARGET_PREFIX}gnat ]; then
                ln -sf ${TARGET_PREFIX}gnat gnat || true
        fi
        if [ -e ${TARGET_PREFIX}gnatbind ]; then
                ln -sf ${TARGET_PREFIX}gnatbind gnatbind || true
        fi
        if [ -e ${TARGET_PREFIX}gnatchop ]; then
                ln -sf ${TARGET_PREFIX}gnatchop gnatchop || true
        fi
        if [ -e ${TARGET_PREFIX}gnatclean ]; then
                ln -sf ${TARGET_PREFIX}gnatclean gnatclean || true
        fi
        if [ -e ${TARGET_PREFIX}gnatfind ]; then
                ln -sf ${TARGET_PREFIX}gnatfind gnatfind || true
        fi
        if [ -e ${TARGET_PREFIX}gnatkr ]; then
                ln -sf ${TARGET_PREFIX}gnatkr gnatkr || true
        fi
        if [ -e ${TARGET_PREFIX}gnatlink ]; then
                ln -sf ${TARGET_PREFIX}gnatlink gnatlink || true
        fi
        if [ -e ${TARGET_PREFIX}gnatls ]; then
                ln -sf ${TARGET_PREFIX}gnatls gnatls || true
        fi
        if [ -e ${TARGET_PREFIX}gnatmake ]; then
                ln -sf ${TARGET_PREFIX}gnatmake gnatmake || true
        fi
        if [ -e ${TARGET_PREFIX}gnatname ]; then
                ln -sf ${TARGET_PREFIX}gnatname gnatname || true
        fi
        if [ -e ${TARGET_PREFIX}gnatprep ]; then
                ln -sf ${TARGET_PREFIX}gnatprep gnatprep || true
        fi
        if [ -e ${TARGET_PREFIX}gnatxref ]; then
                ln -sf ${TARGET_PREFIX}gnatxref gnatxref || true
        fi
}
