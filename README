Ada layer for Yocto
-------------------

This adds support for building Ada programs under Yocto. This is a work in
progress and more Ada libs will be added in future.

The main branch is for Denzil and GCC 4.6.

To build, you need a GCC that understands Ada, this causes problems for some
systems, i.e. on my Debian testing 64-bit, where the main compiler does not
understand Ada and the Ada compiler has it's own gcc/g++. I was not able to
force Yocto to build using gcc-4.6 and g++-4.6. I had to hack it by compiling
my own GCC-4.6.3 toolchain and fixing the multiarch problems with soft links
to crt[i1n].o and lib[cm].[a|so]. Any hints getting this to work would be
greatly appreciated.

** This build will not build shared libs under Yocto/Poky

See recipes-test/libhello to see how to build a library under Yocto, and see
recipes-test/hello so see how to use it under Yocto.

Debian / Ubuntu
---------------

Before building you need gnat, but as these packages are separate from the
stock gcc and also a different version, you have to make sure Yocto will
use the correct compilers. I create a new directory with links and then
export those in my path:

sudo mkdir -p /opt/gnat-4.6-links/bin
sudo cd /opt/gnat-4.6-links/bin
sudo ln -s /usr/bin/gcc-4.6 gcc
sudo ln -s /usr/bin/g++-4.6 g++
sudo ln -s /usr/bin/cpp-4.6 cpp

export PATH=/opt/gnat-4.6-links/bin:$PATH

N.B: Do not export a link to ld but using gcc-4.6 as this will fail to build
due to specific ld flags being passed into gcc which it won't understand.

If you get an error complaining that the compiler driver cannot find the
gnat1 compiler, add the following link to the above directory:

sudo ln -s /usr/lib/gcc/x86_64-linux-gnu/4.6/gnat1 gnat1

Add meta-ada into the build/conf/bblayers.conf
----------------------------------------------

  <path-to>/yocto/gumstix/poky/meta-gumstix \
  <path-to>/yocto/gumstix/poky/meta-ada \
  "

Add the following the build/conf/local.conf
-------------------------------------------

# These do not build yet.
BBMASK = "gprbuild|xmlada"

# Delete the work directories after a successful build.
INHERIT = "rm_work"

# Can delete this once you have a working Yocto.
IMAGE_INSTALL_append = " hello"

# Add to the following variable to make the Ada projects available to gnatmake:
GPR_PROJECT_PATH = "${STAGING_LIBDIR}/ada/libhello"
#GPR_PROJECT_PATH .= ":${STAGING_LIBDIR}/ada/<project name>"
export GPR_PROJECT_PATH

