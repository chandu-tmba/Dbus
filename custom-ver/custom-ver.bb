SUMMARY = "Proprietary DBus Server"
DESCRIPTION = "A proprietary DBus server that overrides get and set methods for a specific property."
LICENSE = "CLOSED"

# If using a local tarball, use:
SRC_URI = "file://custom_server.cpp  \
           file://main.cpp \
           file://custom.service \
           file://meson.build \
           "

S = "${WORKDIR}"

DEPENDS = "phosphor-dbus-interfaces sdbusplus systemd"

inherit meson systemd pkgconfig


# Ensure the systemd service file is recognized
SYSTEMD_SERVICE:${PN} = "custom.service"


# Install the binary
do_install() {
    install -d ${D}${bindir}
    install -m 0755 custom-server ${D}${bindir}/custom-server

    # Install the systemd service file
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/custom.service ${D}${systemd_system_unitdir}/custom.service
}

# Add to default image
INSANE_SKIP:${PN} += "ldflags"

