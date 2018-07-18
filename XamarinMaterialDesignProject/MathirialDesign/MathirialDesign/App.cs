using Android.App;

namespace MathirialDesign
{
    public class App : Application
    {
        public override void OnCreate()
        {
            base.OnCreate();

            SetupCallygraphyConfig();
        }

        private void SetupCallygraphyConfig()
        {
            /*
            CalligraphyConfig.InitDefault(new CalligraphyConfig.Builder()
                .SetDefaultFontPath("fonts/gtw.ttf")
                .SetFontAttrId(Resource.Attribute.fontPath)
                // Adding a custom view that support adding a typeFace
                // .AddCustomViewWithSetTypeface(Java.Lang.Class.FromType(typeof(CustomViewWithTypefaceSupport)))
                // Adding a custom style
                // .AddCustomStyle(Java.Lang.Class.FromType(typeof(TextField)), Resource.Attribute.textFieldStyle)
                .Build());
            */
        }
    }
}
