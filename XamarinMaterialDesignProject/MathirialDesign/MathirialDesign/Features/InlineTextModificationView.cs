using System;
using Android.App;
using Android.Content;
using Android.Graphics;
using Android.OS;
using Android.Support.V7.App;
using Android.Text;
using Android.Text.Style;
using Android.Widget;
using Calligraphy;

namespace MathirialDesign
{
    [Activity]
    public class InlineTextModificationView : AppCompatActivity
    {
        private TextView _textView;
        private TextView _textViewWithCustomFont;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.ActivityInlineTextModification);

            _textView = FindViewById<TextView>(Resource.Id.SimpleTextView);
            SetText(_textView);
            SetTextColorPart(_textView);

            _textViewWithCustomFont = FindViewById<TextView>(Resource.Id.SimpleTextViewWithCustomFont);
            SetText(_textViewWithCustomFont);
            SetTextColorPart(_textViewWithCustomFont);
        }

        protected override void AttachBaseContext(Context @base)
        {
            base.AttachBaseContext(CalligraphyContextWrapper.Wrap(@base));
        }

        private void SetTextColorPart(TextView textView)
        {
            var spannableString = new SpannableString(textView.Text);

            var color = GetRandomColor();
            var forgroundColor = new ForegroundColorSpan(color);
            spannableString.SetSpan(forgroundColor, 0, 10, SpanTypes.InclusiveInclusive);

            textView.TextFormatted = spannableString;
        }

        public static Color GetRandomColor()
        {
            var maxValue = 255;

            var random = new Random();
            var red = random.Next(maxValue);
            var green = random.Next(maxValue);
            var blue = random.Next(maxValue);

            var color = new Color((byte)red, (byte)green, (byte)blue, (byte)255);

            return color;
        }

        private void SetText(TextView textView)
        {
            textView.Text = "Lorizzle ipsizzle dolor sizzle amizzle, consectetuer adipiscing boom shackalack. Nullizzle sapizzle velizzle, fo shizzle, suscipizzle fo shizzle, gravida vizzle, shut the shizzle up. Pellentesque dang tortor. Sed erizzle. Owned fizzle dolizzle dapibus turpis tempizzle shizzle my nizzle crocodizzle.";
        }
    }
}
