#
# Copyright (C) 2012 Wind River Systems, Inc.
#
DESCRIPTION = "An image with Sato support."

LICENSE = "MIT"

# we just extend glibc-std
#
require wrlinux-image-glibc-std.bb

# override PR in glibc-std
#
PR = "r0"

# sato (x11)
#
IMAGE_FEATURES += "${ENHANCED_IMAGE_FEATURES} x11-sato"

