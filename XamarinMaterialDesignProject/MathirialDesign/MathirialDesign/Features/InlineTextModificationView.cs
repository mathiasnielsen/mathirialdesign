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
using MathirialDesign.Builders;

namespace MathirialDesign
{
    [Activity]
    public class InlineTextModificationView : AppCompatActivity
    {
        private TextView _textView;
        private TextView _textViewWithCustomFont;
        private Button _changeColorButton;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.ActivityInlineTextModification);

            var color = GetRandomColor();

            _textView = FindViewById<TextView>(Resource.Id.SimpleTextView);
            SetText(_textView);
            SetSpannableString(_textView, color);

            _textViewWithCustomFont = FindViewById<TextView>(Resource.Id.SimpleTextViewWithCustomFont);
            SetText(_textViewWithCustomFont);
            SetSpannableString(_textViewWithCustomFont, color);

            _changeColorButton = FindViewById<Button>(Resource.Id.ChangeColorBtn);
            _changeColorButton.Click += (sender, e) => 
            {
                var newColor = GetRandomColor();
                SetSpannableString(_textView, newColor);
                SetSpannableString(_textViewWithCustomFont, newColor);
            };
        }

        protected override void AttachBaseContext(Context @base)
        {
            base.AttachBaseContext(CalligraphyContextWrapper.Wrap(@base));
        }

        private void SetSpannableString(TextView textView, Color color)
        {
            BuildString(textView, color);
        }

        private void BuildString(TextView textView, Color color)
        {
            textView.TextFormatted = SpannableStringTextBuilder
                .Build(textView.Text)
                .AddColor(color, 0, 10);
        }

        private void SetTextColorPart(TextView textView, Color color)
        {
            var spannableString = new SpannableString(textView.Text);

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
