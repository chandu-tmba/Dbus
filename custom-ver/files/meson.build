project('my-custom-server', 'cpp',
        version: '1.0',
        default_options: ['cpp_std=c++20'])

# Dependencies
sdbusplus_dep = dependency('sdbusplus')
phosphor_dbus_interfaces_dep = dependency('phosphor-dbus-interfaces')

# Source files
sources = [
    'custom_server.cpp',
    'main.cpp',
]

# Include directories
include_dirs = include_directories('.')

# Build the executable
executable('custom-server',
           sources,
           include_directories: include_dirs,
           dependencies: [sdbusplus_dep, phosphor_dbus_interfaces_dep],
           install: true,
           install_dir: get_option('bindir'))
