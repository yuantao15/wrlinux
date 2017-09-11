#
# Copyright (C) 2012 Wind River Systems, Inc.
#
SUMMARY    ="Virtual Route Forwarding foundation package"

DESCRIPTION="Based on Linux container and underlying namespace, \
vrf package provides a framework to make easier to establish \
virtual router/switch with WRLinux"

SECTION    ="network"
LICENSE    ="GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI    = "file://vrf-1.1.tgz \
"


S  = "${WORKDIR}/wrlinux-vrf"

#lxc-checkconfig depends on gzip's zgrep
RDEPENDS_${PN}   += "lxc libcgroup coreutils gzip"

#vlan and macvlan interfaces support in vrf
RRECOMMENDS_${PN} ="kernel-module-macvlan kernel-module-8021q"

inherit autotools

#configure where to store configuration files, vr's rootfs
#for example: /etc/vrf /usr/local/vrf
VRF_SYSDIR    = "/vrf/etc"
VRF_ROOTFSDIR = "/vrf/fs"

#define WRLINUX for example 
EXTRA_OECONF += "--with-vrf-sysconfdir='${VRF_SYSDIR}' \
	         --with-vrf-datadir='${VRF_ROOTFSDIR}' \
	         --enable-wrlinux"


FILES_${PN}  += "${VRF_SYSDIR}/package/"