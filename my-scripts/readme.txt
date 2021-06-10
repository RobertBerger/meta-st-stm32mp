1) create a new repo on github

2) add my-scripts dir

cd meta-st-stm32mp

echo "# meta-st-stm32 fork" >> README.md

git init

git add .

git commit -m "first commit"

git remote add origin git@github.com:RobertBerger/meta-st-stm32mp.git

git push -u origin master

3) use my repo

mv meta-st-stm32mp meta-st-stm32mp.ori
git clone git@github.com:RobertBerger/meta-st-stm32mp.git

4) add upstream

cd meta-st-stm32mp

git remote add official-upstream git://github.com/STMicroelectronics/meta-st-stm32mp

$ git fetch official-upstream

warning: no common commits
remote: Enumerating objects: 2137, done.
remote: Counting objects: 100% (486/486), done.
remote: Compressing objects: 100% (328/328), done.
remote: Total 2137 (delta 210), reused 357 (delta 149), pack-reused 1651
Receiving objects: 100% (2137/2137), 4.03 MiB | 5.42 MiB/s, done.
Resolving deltas: 100% (1005/1005), done.
From git://github.com/STMicroelectronics/meta-st-stm32mp
 * [new branch]      dunfell    -> official-upstream/dunfell
 * [new branch]      gatesgarth -> official-upstream/gatesgarth
 * [new branch]      hardknott  -> official-upstream/hardknott
 * [new branch]      master     -> official-upstream/master
 * [new branch]      thud       -> official-upstream/thud
 * [new branch]      warrior    -> official-upstream/warrior
 * [new branch]      zeus       -> official-upstream/zeus
 * [new tag]         openstlinux-20-02-19                  -> openstlinux-20-02-19
 * [new tag]         openstlinux-4.19-thud-mp1-19-02-20    -> openstlinux-4.19-thud-mp1-19-02-20
 * [new tag]         openstlinux-4.19-thud-mp1-19-04-05    -> openstlinux-4.19-thud-mp1-19-04-05
 * [new tag]         openstlinux-4.19-thud-mp1-19-10-09    -> openstlinux-4.19-thud-mp1-19-10-09
 * [new tag]         openstlinux-5.10-dunfell-mp1-21-03-31 -> openstlinux-5.10-dunfell-mp1-21-03-31
 * [new tag]         openstlinux-5.4-dunfell-mp1-20-06-24  -> openstlinux-5.4-dunfell-mp1-20-06-24
 * [new tag]         openstlinux-5.4-dunfell-mp1-20-11-12  -> openstlinux-5.4-dunfell-mp1-20-11-12

$ git branch -a

* master
  remotes/official-upstream/dunfell
  remotes/official-upstream/gatesgarth
  remotes/official-upstream/hardknott
  remotes/official-upstream/master
  remotes/official-upstream/thud
  remotes/official-upstream/warrior
  remotes/official-upstream/zeus
  remotes/origin/HEAD -> origin/master
  remotes/origin/master

$git tag -l

openstlinux-20-02-19
openstlinux-4.19-thud-mp1-19-02-20
openstlinux-4.19-thud-mp1-19-04-05
openstlinux-4.19-thud-mp1-19-10-09
openstlinux-5.10-dunfell-mp1-21-03-31
openstlinux-5.4-dunfell-mp1-20-06-24
openstlinux-5.4-dunfell-mp1-20-11-12

Phytec uses this commit 955b1d9a5f706013d718687b1afa6e3022c68fac for the pd21.1.0 release

$ git show 955b1d9a5f706013d718687b1afa6e3022c68fac
commit 955b1d9a5f706013d718687b1afa6e3022c68fac (tag: openstlinux-5.4-dunfell-mp1-20-11-12)
Author: Christophe Priouzeau <christophe.priouzeau@st.com>
Date:   Tue Oct 27 12:19:21 2020 +0100

    M4PROJECTS: Update to v1.3.0

    Change-Id: Iebd0edc92d4d8917cf1c5098a45304a43ee699c1

diff --git a/recipes-extended/m4projects/m4projects-stm32mp1.bb b/recipes-extended/m4projects/m4projects-stm32mp1.bb
index d71f3b7..fa5fff0 100644
--- a/recipes-extended/m4projects/m4projects-stm32mp1.bb
+++ b/recipes-extended/m4projects/m4projects-stm32mp1.bb
@@ -7,9 +7,9 @@ LICENSE = " \
 LIC_FILES_CHKSUM = "file://License.md;md5=5272d12bc1c2e29908b787134d73dae9"

 SRC_URI = "git://github.com/STMicroelectronics/STM32CubeMP1.git;protocol=https;branch=master"
-SRCREV  = "c604fa0965c73e430eebd5fa780180beb9a71b44"
+SRCREV  = "39fe4ecb2871a844720f6e039f7fa91be9294bdf"

-PV = "1.2.0"
+PV = "1.3.0"

 S = "${WORKDIR}/git"

5) use specific tag/commit and make own branch

git co 955b1d9a5f706013d718687b1afa6e3022c68fac

$ git co 955b1d9a5f706013d718687b1afa6e3022c68fac
Note: checking out '955b1d9a5f706013d718687b1afa6e3022c68fac'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by performing another checkout.

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -b with the checkout command again. Example:

  git checkout -b <new-branch-name>

HEAD is now at 955b1d9 M4PROJECTS: Update to v1.3.0

make branch out of it

$ git checkout -b 2021-06-08-955b1d9a5f706013d718687b1afa6e3022c68fac-pd21.1.0-dunfell
Switched to a new branch '2021-06-08-955b1d9a5f706013d718687b1afa6e3022c68fac-pd21.1.0-dunfell'

$ git branch
* 2021-06-08-955b1d9a5f706013d718687b1afa6e3022c68fac-pd21.1.0-dunfell
  master

our hacked version of this branch (subset and modifications)

$ git branch 2021-06-09-pd21.1.0-subset-dunfell-as-hardknott
$ git co 2021-06-09-pd21.1.0-subset-dunfell-as-hardknott
Switched to branch '2021-06-09-pd21.1.0-subset-dunfell-as-hardknott'
$ git branch
  2021-06-08-955b1d9a5f706013d718687b1afa6e3022c68fac-pd21.1.0-dunfell
* 2021-06-09-pd21.1.0-subset-dunfell-as-hardknott
  master

#5) use specific upstream branch/commit and make own branch
#
#syntax: git fetch url-to-repo branchname:refs/remotes/origin/branchname
#
#$ git fetch git://github.com/STMicroelectronics/meta-st-stm32mp dunfell:refs/remotes/origin/dunfell
#
#From git://github.com/Freescale/meta-freescale
# * [new branch]        dunfell    -> origin/dunfell
#

#6) Update from upstream:
#git co master
#>> git remote -v
#
#official-upstream       git://github.com/Freescale/meta-freescale (fetch)
#official-upstream       git://github.com/Freescale/meta-freescale (push)
#origin  git@github.com:RobertBerger/meta-freescale.git (fetch)
#origin  git@github.com:RobertBerger/meta-freescale.git (push)
#
#>> git fetch official-upstream
#remote: Counting objects: 4043, done.
#remote: Compressing objects: 100% (1273/1273), done.
#remote: Total 4043 (delta 3130), reused 3632 (delta 2727)
#Receiving objects: 100% (4043/4043), 721.50 KiB | 402.00 KiB/s, done.
#Resolving deltas: 100% (3130/3130), completed with 502 local objects.
#From git://git://github.com/Freescale/meta-freescale
#   62591d9..e758547  master     -> official-upstream/master
# + 2942327...a382678 master-next -> official-upstream/master-next  (forced update)
#   a3fa5ce..6a1f33c  morty      -> official-upstream/morty
#---
#

6) hack the branch and update

6.1) hack it

6.2) add/commit

6.3) What was changed?

$ git diff 2021-06-08-955b1d9a5f706013d718687b1afa6e3022c68fac-pd21.1.0-dunfell --stat
 conf/layer.conf                                                                                       |   2 +-
 recipes-connectivity/bluetooth/bluetooth-suspend.bb                                                   |  28 ------------
 recipes-connectivity/bluetooth/bluetooth-suspend/bluetooth-brcmfmac-sleep.service                     |  13 ------
 recipes-connectivity/bluetooth/bluetooth-suspend/bluetooth_brcmfmac_driver.sh                         |  44 -------------------
 recipes-connectivity/wifi/wifi-suspend.bb                                                             |  28 ------------
 recipes-connectivity/wifi/wifi-suspend/wifi-brcmfmac-sleep.service                                    |  13 ------
 recipes-connectivity/wifi/wifi-suspend/wifi_brcmfmac_driver.sh                                        |  54 -----------------------
 recipes-core/base-files/base-files/fstab                                                              |  11 -----
 recipes-core/base-files/base-files_%.bbappend                                                         |   1 -
 recipes-core/busybox/busybox/0001-miscutils-watchdog-Add-gettimeleft.patch                            |  38 ----------------
 recipes-core/busybox/busybox/busybox-stm32mp.cfg                                                      |  13 ------
 recipes-core/busybox/busybox/ifplugd.action                                                           |  20 ---------
 recipes-core/busybox/busybox/ifplugd.conf                                                             |   2 -
 recipes-core/busybox/busybox/ifplugd.sh                                                               |   5 ---
 recipes-core/busybox/busybox_%.bbappend                                                               |  33 --------------
 recipes-core/dropbear/dropbear_%.bbappend                                                             |   2 -
 recipes-core/meta/target-sdk-provides-dummy.bbappend                                                  |   1 -
 recipes-core/systemd/systemd-conf_%.bbappend                                                          |   9 ----
 recipes-devtools/sdcard-raw-tools/sdcard-raw-tools.bb                                                 |   2 +-
 recipes-graphics/drm/libdrm/0001-tests-modetest-automatic-configuration.patch                         | 125 ----------------------------------------------------
 recipes-graphics/drm/libdrm/0002-tests-util-smtpe-increase-alpha-to-middle-band.patch                 |  48 --------------------
 recipes-graphics/drm/libdrm/0003-tests-modetest-set-property-in-atomic-mode.patch                     |  43 ------------------
 recipes-graphics/drm/libdrm/0004-tests-modetest-close-crtc.patch                                      |  42 ------------------
 recipes-graphics/drm/libdrm_2.4.101.bbappend                                                          |  11 -----
 recipes-graphics/gcnano-userland/gcnano-userland-binary.inc                                           | 193 --------------------------------------------------------------------------------
 recipes-graphics/gcnano-userland/gcnano-userland-multi-binary-debug-stm32mp.bb                        |  17 -------
 recipes-graphics/gcnano-userland/gcnano-userland-multi-binary-stm32mp.bb                              |  15 -------
 recipes-graphics/mesa/mesa-gl_%.bbappend                                                              |   3 --
 recipes-graphics/mesa/mesa_%.bbappend                                                                 |  12 -----
 recipes-graphics/wayland/weston-init.bbappend                                                         |   2 -
 recipes-graphics/wayland/weston-init/weston.ini                                                       | 102 ------------------------------------------
 recipes-graphics/wayland/weston/xwayland.weston-start                                                 |   7 ---
 recipes-graphics/wayland/weston_%.bbappend                                                            |   1 -
 recipes-multimedia/pulseaudio/pulseaudio/default.pa                                                   | 137 ---------------------------------------------------------
 recipes-multimedia/pulseaudio/pulseaudio/system.pa                                                    |  76 --------------------------------
 recipes-multimedia/pulseaudio/pulseaudio_%.bbappend                                                   |  23 ----------
 recipes-st/images/st-image-userfs.bb                                                                  |   8 +++-
 recipes-support/hidapi/hidapi-stm32mp/0001-configure.ac-remove-duplicate-AC_CONFIG_MACRO_DIR-22.patch |  27 ++++++++++++
 recipes-support/hidapi/hidapi-stm32mp_0.8.0-rc1.bb                                                    |   4 +-
 39 files changed, 39 insertions(+), 1176 deletions(-)

7) push upstream:
git co master
cd my-scripts
./push-all-to-github.sh

#8) apply patches
#
#cd meta-virtualization
#
#git co 2019-09-09-warrior-2.7+
#
#stg init
#
#stg series
#
#stg import --mail ../meta-virtualization-patches/2019-09-09-warrior-2.7+/0001-use-systemd-as-cgroup-manager-for-docker-While-it-s-.patch
#
#import all patches
#
#...
#
#stg series
#
#stg commit --all
#
#git log
#
#git co master
#
9) push to my upstream

my-scripts/push-all-to-github.sh

