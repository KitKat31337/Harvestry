package harvestry.sided.proxy;

import harvestry.utils.Archive;

import com.jadarstudios.api.developercapesapi.DeveloperCapesAPI;

public class ClientProxy extends CommonProxy {

    // Code that adds capes :D Github link for it to work:
    // https://github.com/jadar/DeveloperCapesAPI
    @Override
    public void initCapes() {
        // Link for the file that makes the capes work
        DeveloperCapesAPI.init(Archive.capes);
    }
}