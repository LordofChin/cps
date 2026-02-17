public class Driver
{
	public static void main(String [] args)
	{
		TeaBuilder builder = new TeaBuilder();
		builder.setType("green");
		builder.setMilk("almond");
		builder.setSugar(30);
		Tea tea = builder.build();
		System.out.println(tea);
	}
}

class TeaBuilder
{	
	private String type;
	private String milk;
	private int sugar;
	
	TeaBuilder(){
		this.type = "iced";
		this.milk = "2%";
		this.sugar = 1;
	}
	TeaBuilder(String type, String milk, int sugar)
	{
		this.type = type;
		this.milk = milk;
		this.sugar = sugar;
	}
	
	
	TeaBuilder setType(String type)
	{
		this.type = type;
		return this;
	}
	TeaBuilder setMilk(String milk)
	{
		this.milk = milk;
		return this;	
	}
	TeaBuilder setSugar(int sugar)
	{
		this.sugar = sugar;
		return this;
	}
	
	String getType()
	{
		return this.type;
	}
	String getMilk()
	{
		return this.milk;
	}
	int getSugar()
	{
		return this.sugar;
	}


	Tea build()
	{
		return new Tea(this.getType(), this.getMilk(),this.getSugar());
	}
	
		
}

class Tea
{	
	private String type;
	private String milk;
	private int sugar;
	
	public Tea(){}
	Tea(String type, String milk, int sugar)
	{
		this.type = type;
		this.milk = milk;
		this.sugar = sugar;
	}

	@Override
	public String toString()
	{
		return (this.type + " tea with " + this.milk + " milk and " + this.sugar + " sugar(s)."); 
	} 
}