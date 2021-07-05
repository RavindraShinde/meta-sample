SUMMARY = "Copy the lib and other files"
DESCRIPTION = "Copying the lib files and other files to the RFS"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${TOPDIR}/../source/meta-sample/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = " \
   file://add.c \
   file://mul.c \
   file://myheader.h"

S = "${WORKDIR}"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev"
#PACKAGES = "${PN} ${PN}-doc ${PN}-dev ${PN}-dbg ${PN}-staticdev"

RDEPENDS_${PN}-staticdev = ""
RDEPENDS_${PN}-dev = ""
RDEPENDS_${PN}-dbg = ""

do_compile() {
    ${CC} -c add.c -o add.o
    ${CC} -c mul.c -o mul.o
    ${AR} rcs libmy.a add.o mul.o
}
 
do_install() {
    # create the /usr/bin within the rfs with default permissions(-d)
    install -d ${D}${libdir} 

    # create the /usr/include within the rfs with default
    install -d ${D}${includedir}

    # install the library to /usr/bin 
    install -m 0644 libmy.a ${D}${libdir}

    # install the header to /usr/bin 
    install -m 0644 myheader.h ${D}${includedir}
}

