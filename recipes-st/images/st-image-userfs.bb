SUMMARY = "STM32MP userfs Image"
LICENSE = "MIT"

include recipes-st/images/st-image-partitions.inc

# Define to null ROOTFS_MAXSIZE
IMAGE_ROOTFS_MAXSIZE = ""

# Add specific package for our image:

# rber removed for now:
# m4projects-stm32mp1-userfs

PACKAGE_INSTALL += " \
    linux-examples-stm32mp1-userfs \
    "



# Add demo application described on specific packagegroup

PACKAGE_INSTALL += " \
    packagegroup-st-demo \
    "
