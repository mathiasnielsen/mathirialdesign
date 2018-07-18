using Android.Graphics;
using Android.Text;
using Android.Text.Style;
using MathirialDesign.Utilities;

namespace MathirialDesign.Builders
{
    public static class SpannableStringTextBuilder
    {
        public static SpannableString Build(string text)
        {
            return new SpannableString(text);
        }

        public static SpannableString AddBold(this SpannableString spannableString, int startIndex, int length)
        {
            var boldStyleSpan = new StyleSpan(TypefaceStyle.Bold);
            spannableString.SetSpan(boldStyleSpan, startIndex, startIndex + length, SpanTypes.ExclusiveExclusive);

            return spannableString;
        }

        public static SpannableString AddColor(this SpannableString spannableString, Color color, int startIndex, int length)
        {
            var forgroundColor = new ForegroundColorSpan(color);
            spannableString.SetSpan(forgroundColor, startIndex, startIndex + length, SpanTypes.InclusiveInclusive);

            return spannableString;
        }

        public static SpannableString AddFont(this SpannableString spannableString, Typeface typeface, int startIndex, int length)
        {
            var typefaceStyleSpan = new CustomTypefaceSpan(typeface);
            spannableString.SetSpan(typefaceStyleSpan, startIndex, startIndex + length, SpanTypes.ExclusiveExclusive);

            return spannableString;
        }

        public static SpannableString AddLink(this SpannableString spannableString, Color color, Typeface typeface, string url, int startIndex, int length)
        {
            AddColor(spannableString, color, startIndex, length);
            AddFont(spannableString, typeface, startIndex, length);

            var urlSpan = new URLSpan(url);
            spannableString.SetSpan(urlSpan, startIndex, startIndex + length, SpanTypes.ExclusiveExclusive);

            return spannableString;
        }
    }
}
