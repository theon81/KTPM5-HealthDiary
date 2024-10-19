document.addEventListener('DOMContentLoaded', () => {
    const iframe = document.querySelector('iframe');
    const root = document.documentElement;

    const themes = {
        userinfo: {
            '--default-icon-color': '#4D869C',
            '--nav-background': '#EEF7FF',
            '--hovered-background-color': '#4D869C',
            '--hovered-icon-color': '#EEF7FF'
        },
        water: {
            '--default-icon-color': '#92C7CF',
            '--nav-background': '#FBF9F1',
            '--hovered-background-color': '#AAD7D9',
            '--hovered-icon-color': '#FBF9F1'
        },
        sleep: {
            '--default-icon-color': '#4D869C',
            '--nav-background': '#232D3F',
            '--hovered-background-color': '#98DED9',
            '--hovered-icon-color': '#135D66'
        },
        diet: {
            '--default-icon-color': '#AFC8AD',
            '--nav-background': '#F2F1EB',
            '--hovered-background-color': '#88AB8E',
            '--hovered-icon-color': '#EEE7DA'
        }
    };

    function updateTheme(theme) {
        const variables = themes[theme];
        for (const [key, value] of Object.entries(variables)) {
            root.style.setProperty(key, value);
        }
    }

    function updateActiveNavItem() {
        const currentSrc = iframe.contentWindow.location.pathname;
        if (currentSrc.includes('/userinfo')) {
            updateTheme('userinfo');
        } else if (currentSrc.includes('/water')) {
            updateTheme('water');
        } else if (currentSrc.includes('/sleep')) {
            updateTheme('sleep');
        } else if (currentSrc.includes('/diet')) {
            updateTheme('diet');
        }
    }

    iframe.addEventListener('load', updateActiveNavItem);
    updateActiveNavItem(); // Initial call to set the active item on page load
});