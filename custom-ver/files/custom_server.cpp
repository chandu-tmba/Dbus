#include "xyz/openbmc_project/Software/Version/server.hpp"
#include <iostream>


using ExistingServer = sdbusplus::server::object_t<sdbusplus::server::xyz::openbmc_project::software::Version>;

class MyCustomServer : public ExistingServer
{
  public:
    MyCustomServer(sdbusplus::bus::bus& bus, const char* path) :
        ExistingServer(bus, path) {}

    std::string version() const override
    {
	  std::cerr << "get custom version called \n";
	  return cversion;
    }

    std::string version(std::string value) override
    {
	 cversion = value;
	 std::cerr << "set custom version called \n";   
	 return cversion;
    }
  private:
    std::string cversion;  
};
