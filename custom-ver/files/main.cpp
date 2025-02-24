#include <custom_server.cpp> // Include your custom server header

int main()
{
    auto bus = sdbusplus::bus::new_default();
    bus.request_name("custom.version");
    MyCustomServer server(bus, "/custom/version");
    
    // Run the server
    while (true)
    {
        bus.process();
    }

    return 0;
}
