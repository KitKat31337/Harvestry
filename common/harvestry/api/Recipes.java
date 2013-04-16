package harvestry.api;

import net.minecraft.item.ItemStack;

public class Recipes {
    private ItemStack input;
    private ItemStack output1;
    private ItemStack output2;

    private boolean hasSecondOutput;

    public Recipes(ItemStack input, ItemStack output1, ItemStack output2) {
        this(input, output1);
        this.output2 = output2;
        hasSecondOutput = true;
    }

    public Recipes(ItemStack input, ItemStack output1) {
        super();
        this.input = input;
        this.output1 = output1;
        this.hasSecondOutput = false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (hasSecondOutput ? 1231 : 1237);
        result = prime * result + ((input == null) ? 0 : input.hashCode());
        result = prime * result + ((output1 == null) ? 0 : output1.hashCode());
        result = prime * result + ((output2 == null) ? 0 : output2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Recipes other = (Recipes) obj;
        if (hasSecondOutput != other.hasSecondOutput)
            return false;
        if (input == null){
            if (other.input != null)
                return false;
        }else if (!input.equals(other.input))
            return false;
        if (output1 == null){
            if (other.output1 != null)
                return false;
        }else if (!output1.equals(other.output1))
            return false;
        if (output2 == null){
            if (other.output2 != null)
                return false;
        }else if (!output2.equals(other.output2))
            return false;
        return true;
    }

    public boolean isInput(ItemStack stack) {
        return this.input.isItemEqual(stack);
    }

    public ItemStack getOutput1() {
        return output1;
    }

    public ItemStack getOutput2() {
        return output2;
    }

    public boolean hasSecondOutput() {
        return hasSecondOutput;
    }

}
