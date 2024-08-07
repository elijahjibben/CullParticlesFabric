package tfar.cullparticles;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;

public class MixinHooks {
  // Checks if the current frustum (player's visibility) contains particles. If so Minecraft's particle engine will render.
  // If not, rendering will be skipped.
  public static void cullParticles(Particle particle, VertexConsumer consumer, Camera camera, float deltaTime) {
    if (((Capture)MinecraftClient.getInstance().worldRenderer).capturedFrustum().isVisible(particle.getBoundingBox()))
      particle.buildGeometry(consumer,camera,deltaTime);
  }
}
